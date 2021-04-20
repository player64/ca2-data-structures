package com.ca2.rotateAnalysis;

public class AnalysisTableContent {
    private String head;
    private String body;

    AnalysisTableContent(String title) {
        head = "# " + title;
        head += "\n| IList type | IList.rotate() | GenericCollections.rotate(<IList>) | GenericCollections.rotate2(<IList>) |\n";
        head += "| --- | --- | --- | --- |\n";
    }

    private String getHead() {
        return head;
    }


    private String getBody() {
        return body;
    }

    public void setRow(String body) {
        if (this.body != null) {
            this.body += "\n" + body;
        } else {
            this.body = body;
        }
    }

    public String produceTable() {
        return getHead() + getBody();
    }
}
