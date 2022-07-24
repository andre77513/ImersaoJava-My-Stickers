import java.util.List;

public interface ContentExtractor {

    public List<ImdbContents> contentExtractors(String body);
    
}
