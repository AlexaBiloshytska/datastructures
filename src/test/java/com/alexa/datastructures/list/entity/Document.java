package com.alexa.datastructures.list.entity;

public class Document {
    private int documentid;
    private String content;
    private String documentName;

    public Document(int documentid, String content, String documentName) {
        this.documentid = documentid;
        this.content = content;
        this.documentName = documentName;
    }

    public int getDocumentid() {
        return documentid;
    }

    public String getContent() {
        return content;
    }

    public String getDocumentName() {
        return documentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (documentid != document.documentid) return false;
        if (!content.equals(document.content)) return false;
        return documentName.equals(document.documentName);
    }
}
