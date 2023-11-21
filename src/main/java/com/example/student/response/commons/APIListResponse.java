package com.example.student.response.commons;

public class APIListResponse<T> {
    private int totalPages;
    private Long totalElements;
    private int requestedPage;
    private T list;

    public APIListResponse() {
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public Long getTotalElements() {
        return this.totalElements;
    }

    public int getRequestedPage() {
        return this.requestedPage;
    }

    public T getList() {
        return this.list;
    }

    public void setTotalPages(final int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(final Long totalElements) {
        this.totalElements = totalElements;
    }

    public void setRequestedPage(final int requestedPage) {
        this.requestedPage = requestedPage;
    }

    public void setList(final T list) {
        this.list = list;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof APIListResponse)) {
            return false;
        } else {
            APIListResponse<?> other = (APIListResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotalPages() != other.getTotalPages()) {
                return false;
            } else if (this.getRequestedPage() != other.getRequestedPage()) {
                return false;
            } else {
                label40: {
                    Object this$totalElements = this.getTotalElements();
                    Object other$totalElements = other.getTotalElements();
                    if (this$totalElements == null) {
                        if (other$totalElements == null) {
                            break label40;
                        }
                    } else if (this$totalElements.equals(other$totalElements)) {
                        break label40;
                    }

                    return false;
                }

                Object this$list = this.getList();
                Object other$list = other.getList();
                if (this$list == null) {
                    if (other$list != null) {
                        return false;
                    }
                } else if (!this$list.equals(other$list)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof APIListResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getTotalPages();
        result = result * 59 + this.getRequestedPage();
        Object $totalElements = this.getTotalElements();
        result = result * 59 + ($totalElements == null ? 43 : $totalElements.hashCode());
        Object $list = this.getList();
        result = result * 59 + ($list == null ? 43 : $list.hashCode());
        return result;
    }

    public String toString() {
        int var10000 = this.getTotalPages();
        return "APIListResponse(totalPages=" + var10000 + ", totalElements=" + this.getTotalElements() + ", requestedPage=" + this.getRequestedPage() + ", list=" + this.getList() + ")";
    }
}
