package com.trianguloy.collapseclosingtags

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import com.jetbrains.rd.generator.nova.PredefinedType

/**
 * Supports storing the application settings in a persistent way.
 * The [State] and [Storage] annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
    name = "com.trianguloy.collapseclosingtags.CollapseFoldingState",
    storages = [Storage("CollapseFoldPlugin.xml")]
)
@Service(Service.Level.PROJECT)
class SettingsState : PersistentStateComponent<SettingsState?> {
    var linesSeparationInclusive = DefaultSetting(1)
    var shortSettings = CollapseSettings(DefaultSetting(""), DefaultSetting(true))
    var longSettings = CollapseSettings(DefaultSetting("^.|(?<=[a-z])[A-Z]|(?<=_)[a-zA-Z]"), DefaultSetting(false))

    override fun getState() = this

    override fun loadState(state: SettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    fun getSettingsForLineSeparation(separation: Int) =
        if (separation <= linesSeparationInclusive.value) shortSettings else longSettings
}

class DefaultSetting<T>(val defaultValue: T, var value: T = defaultValue)

class CollapseSettings(val collapsedText: DefaultSetting<String>, val collapseByDefault: DefaultSetting<Boolean>)