package dev.mihiratrey.documentmanagementsystembackend.domain.models;

public class DocumentTags {
    private Long docId;
    private Long tagId;

    public DocumentTags(Long docId, Long tagId) {
        this.docId = docId;
        this.tagId = tagId;
    }

    public Long getDocId() {
        return docId;
    }

    public Long getTagId() {
        return tagId;
    }
}
