package com.intellij.plugins.bodhi.pmd.annotator;

import com.intellij.openapi.editor.Document;
import net.sourceforge.pmd.lang.document.TextFile;
import net.sourceforge.pmd.renderers.AbstractRenderer;
import net.sourceforge.pmd.reporting.Report;

import java.io.IOException;

class PMDAnnotationRenderer extends AbstractRenderer {

    private Report report;

    PMDAnnotationRenderer() {
        super("Annotations", "Gathers data for annotating IntelliJ editor");
    }

    @Override
    public String defaultFileExtension() {
        return null;
    }

    @Override
    public void start() {
    }

    @Override
    public void startFileAnalysis(TextFile dataSource) {

    }

    @Override
    public void renderFileReport(Report report) {
        if (this.report == null) {
            this.report = report;
        } else {
            this.report = this.report.union(report);
        }
    }

    @Override
    public void end() throws IOException {
    }

    @Override
    public void flush() {
    }

    public PMDAnnotations getResult(Document document) {
        return new PMDAnnotations(report, document);
    }
}
