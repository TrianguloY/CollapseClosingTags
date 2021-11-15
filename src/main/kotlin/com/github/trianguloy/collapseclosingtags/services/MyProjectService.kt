package com.github.trianguloy.collapseclosingtags.services

import com.intellij.openapi.project.Project
import com.github.trianguloy.collapseclosingtags.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
