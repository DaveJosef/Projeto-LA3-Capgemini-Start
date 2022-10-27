
package TodoApp.util;

public enum ButtonType {
    
    EDIT("edit"), DELETE("delete"), ADD("add");
    
    private String typeName;
    
    ButtonType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}
