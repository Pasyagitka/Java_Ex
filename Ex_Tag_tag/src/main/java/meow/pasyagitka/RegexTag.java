package meow.pasyagitka;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class RegexTag  extends TagSupport {
    private String value="";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int doStartTag() {
        JspWriter jspWriter = pageContext.getOut();
        try {
            jspWriter.print("<input type = \"text\" pattern=\"[A-z]{2}[0-9]{4,6}/20\" value =\"" + this.value + "\" />");
        } catch (IOException e) {
            System.out.println("Regex: " + e);
        }
        return EVAL_BODY_INCLUDE;
    }


    public RegexTag() {
        super();
    }
}
