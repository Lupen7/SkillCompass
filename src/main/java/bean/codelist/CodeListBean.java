
package bean.codelist;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import model.codelist.CodeList;
import model.codelist.CodeListType;
import service.CodeListService;

@Named(value = "codelistBean")
@SessionScoped
public class CodeListBean implements Serializable {

    @Inject
    private CodeListService service;
    private List<? extends CodeList> items;
            
    public CodeListBean() {

    }

    public List<? extends CodeList> getCodeListItems(String CL) {
        CodeListType type = CodeListType.valueOf(CL);
        System.out.println("Loading code-list of type: " + type.getClass()+ ", table: " + type.getTableName());
        items = service.findAll(type.getClass(), type.getTableName());
        return items;
    }
}
