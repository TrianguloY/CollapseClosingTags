package com.trianguloy.collapseclosingtags

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys

class CollapseAllAction : AnAction() {
    override fun update(e: AnActionEvent) {
        // enable if there is at least 1 XML closing tag
        e.presentation.isEnabledAndVisible = e.foldingRegions?.isNotEmpty() ?: false
    }

    override fun actionPerformed(e: AnActionEvent) {
        // collapse all tags in file
        e.getData(LangDataKeys.EDITOR)?.foldingModel
            ?.runBatchFoldingOperation({ e.foldingRegions?.forEach { it.isExpanded = false } }, true, true)
    }

    /**
     * Get all folding regions by checking if the collapsed text is '/'
     * this is wrong, may return more regions, but wasn't able to find a better alternative
     */
    private val AnActionEvent.foldingRegions
        get() = getData(LangDataKeys.EDITOR)?.foldingModel?.allFoldRegions?.filter { it.placeholderText == "/" }
}

