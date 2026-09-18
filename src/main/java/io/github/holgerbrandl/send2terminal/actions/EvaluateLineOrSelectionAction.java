/*
 * Copyright 2011 Holger Brandl
 *
 * This code is licensed under BSD. For details see
 * http://www.opensource.org/licenses/bsd-license.php
 */

package io.github.holgerbrandl.send2terminal.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.terminal.frontend.toolwindow.TerminalToolWindowTab;
import com.intellij.terminal.ui.TerminalWidget;
import com.intellij.ui.content.Content;
import org.jetbrains.plugins.terminal.TerminalToolWindowFactory;
import org.jetbrains.plugins.terminal.TerminalToolWindowManager;

/**
 * Sends the current selection, or the current line when there is no selection,
 * to the active IDE terminal.
 */
public class EvaluateLineOrSelectionAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent actionEvent) {
        Project project = actionEvent.getProject();
        Editor editor = actionEvent.getData(PlatformDataKeys.EDITOR);

        if (project == null || editor == null) {
            return;
        }

        String text = editor.getSelectionModel().getSelectedText();

        if (text == null || text.isBlank()) {
            Document document = editor.getDocument();
            int line = editor.getCaretModel().getLogicalPosition().line;
            int start = document.getLineStartOffset(line);
            int end = document.getLineEndOffset(line);

            text = document.getText(new TextRange(start, end));
        }

        ToolWindow terminalToolWindow = ToolWindowManager.getInstance(project)
                .getToolWindow(TerminalToolWindowFactory.TOOL_WINDOW_ID);

        if (terminalToolWindow == null) {
            return;
        }

        Content content = terminalToolWindow.getContentManager().getSelectedContent();

        if (content == null) {
            return;
        }

        TerminalToolWindowTab terminalTab =
                content.getUserData(TerminalToolWindowTab.Companion.getKEY());

        if (terminalTab != null) {
            terminalTab.getView()
                    .createSendTextBuilder()
                    .shouldExecute()
                    .send(text);

            editor.getSelectionModel().removeSelection();
            return;
        }

        TerminalWidget terminalWidget =
                TerminalToolWindowManager.findWidgetByContent(content);

        if (terminalWidget != null) {
            terminalWidget.sendCommandToExecute(text);
            editor.getSelectionModel().removeSelection();
        }
    }
}