// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.trianguloy.collapseclosingtags

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.xml.XmlTokenImpl
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.xml.XmlTokenType

val USER_DATA = Key.create<Boolean>("com.trianguloy.collapseclosingtags")

class CollapseFoldingBuilder : FoldingBuilderEx() {

    /**
     * Creates and returns the folding of each XML end tag so that </something> is folded into </> (with '/something' -> '/' being the foldable part)
     */
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean) = PsiTreeUtil
        // get all XmlTokenImpl items
        .findChildrenOfType(root, XmlTokenImpl::class.java)
        .asSequence()
        // which are XML_NAME
        .filter { it.elementType == XmlTokenType.XML_NAME }
        // which has a '</' before
        .filter { it.prevSibling?.elementType == XmlTokenType.XML_END_TAG_START }
        // which has a '>' after
        .filter { it.nextSibling?.elementType == XmlTokenType.XML_TAG_END }
        // mark this node. This is the only way I found to be able to identify it later :(
        .onEach { it.putUserData(USER_DATA, true) }
        // convert into a descriptor using the XML_NAME node and ranging '<[/something]>', (standalone group)
        .map { FoldingDescriptor(it.node, TextRange(it.prevSibling.textRange.endOffset - 1, it.textRange.endOffset)) }
        // and return as array
        .toList().toTypedArray()

    /**
     * All placeholder texts are '/' to display '</>'
     */
    override fun getPlaceholderText(node: ASTNode) = "/"

    /**
     * All collapsed by default, of course
     */
    override fun isCollapsedByDefault(node: ASTNode) = true

}