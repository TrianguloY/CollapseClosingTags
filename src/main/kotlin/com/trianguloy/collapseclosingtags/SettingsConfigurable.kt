package com.trianguloy.collapseclosingtags

import com.intellij.ide.plugins.PluginTable
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.table.JBTable
import com.intellij.util.Function
import com.intellij.util.ui.FormBuilder
import com.intellij.util.ui.table.JBListTable
import com.intellij.util.ui.table.TableModelEditor
import javax.swing.JButton
import javax.swing.JPanel

/** Provides controller functionality for application settings. */
class SettingsConfigurable(project: Project) : Configurable {
    private val service = project.getService(SettingsState::class.java)
    private var component: SettingsComponent? = null
    override fun getDisplayName() = "Collapse Closing Tags"

    override fun createComponent() = SettingsComponent().also { component = it }.panel

    override fun getPreferredFocusedComponent() = component?.preferredFocusedComponent

    override fun isModified() =
        service.collapsedText != component?.collapsedText || service.collapsedByDefault != component?.collapsedByDefault

    override fun apply() {
        component?.let {
            service.collapsedText = it.collapsedText
            service.collapsedByDefault = it.collapsedByDefault
        }
    }

    override fun reset() {
        component?.collapsedText = service.collapsedText
        component?.collapsedByDefault = service.collapsedByDefault
    }

    override fun disposeUIResources() {
        component = null
    }
}

/** Supports creating and managing a [JPanel] for the Settings Dialog. */
class SettingsComponent {

    private val collapsedTextField = JBTextField()
    private val collapsedByDefaultField = JBCheckBox("Collapse dependencies by default")

    val panel = FormBuilder.createFormBuilder()
        .addComponent(object : TableModelEditor.DialogItemEditor<String>(){
            override fun getItemClass(): Class<out String> {
                TODO("Not yet implemented")
            }

            override fun applyEdited(oldItem: String, newItem: String) {
                TODO("Not yet implemented")
            }

            override fun edit(item: String, mutator: Function<in String, out String>, isAdd: Boolean) {
                TODO("Not yet implemented")
            }

            override fun clone(item: String, forInPlaceEditing: Boolean): String {
                TODO("Not yet implemented")
            }

        }.compo)

        .addComponentFillVertically(JPanel(), 0)
        .addComponent(JButton("Restore default settings").apply {
            addActionListener {
                collapsedText = DEFAULT_COLLAPSED_TEXT
                collapsedByDefault = DEFAULT_COLLAPSED_BY_DEFAULT
            }
        })
        .panel

    val preferredFocusedComponent get() = collapsedTextField
    var collapsedText
        get() = collapsedTextField.getText()
        set(newText) = collapsedTextField.setText(newText)

    var collapsedByDefault: Boolean
        get() = collapsedByDefaultField.isSelected
        set(newStatus) = collapsedByDefaultField.setSelected(newStatus)
}


private val String.toJLabelMultiline
    get() = "<html>${replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("\n", "<br>")}</html>"