package dev.mihiratrey.documentmanagementsystembackend.domain.models;

public class DocumentPermissions {
    private Long docId;
    private Integer userId;
    private Boolean canView;
    private Boolean canEdit;
    private Boolean canDelete;
    private Boolean isDeleted;

    public DocumentPermissions(Long docId, Integer userId, Boolean canView, Boolean canEdit, Boolean canDelete, Boolean isDeleted) {
        this.docId = docId;
        this.userId = userId;
        this.canView = canView;
        this.canEdit = canEdit;
        this.canDelete = canDelete;
        this.isDeleted = isDeleted;
    }

    public Long getDocId() {
        return docId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Boolean getCanView() {
        return canView;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }
}
