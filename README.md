# Collapse Closing Tags (Jetbrains plugin)

[![Verify plugin](https://github.com/TrianguloY/CollapseClosingTags/actions/workflows/verify.yml/badge.svg)](https://github.com/TrianguloY/CollapseClosingTags/actions/workflows/verify.yml)
[![Version](https://img.shields.io/jetbrains/plugin/v/18020.svg)](https://plugins.jetbrains.com/plugin/18020)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/18020.svg)](https://plugins.jetbrains.com/plugin/18020)

<!-- Plugin description -->
This plugin allows collapsing ending xml tags:

From:

![pre](https://github.com/TrianguloY/CollapseClosingTags/blob/main/pre.png?raw=true)

To:

![post](https://github.com/TrianguloY/CollapseClosingTags/blob/main/post.png?raw=true)

They are implemented using the IDE folding features, so you can use the collapse/expand actions and its keywords.

Additionally, it includes an entry in the right-click menu to collapse all detected tags in the file (if any).
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Collapse Closing
  Tags"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/TrianguloY/CollapseClosingTags/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Plugin originally based on the [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template), but later removed to simplify everything.
