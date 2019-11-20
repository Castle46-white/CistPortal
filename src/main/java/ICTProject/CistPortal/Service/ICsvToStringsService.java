package ICTProject.CistPortal.Service;

import org.apache.wicket.markup.html.form.upload.FileUpload;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public interface ICsvToStringsService {
    /**
     *
     * @param file
     * @param charset
     * @return
     * @throws IOException
     */
    public List<String> convert(FileUpload file, Charset charset) throws IOException;
}
