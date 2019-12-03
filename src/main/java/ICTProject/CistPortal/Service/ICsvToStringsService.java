package ICTProject.CistPortal.service;

import org.apache.wicket.markup.html.form.upload.FileUpload;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public interface ICsvToStringsService {
    /**
     *
     * @param file アップロードされたファイル
     * @param charset 文字の読込形式(UTF-8)
     * @return
     * @throws IOException
     */
    public List<String> convert(FileUpload file, Charset charset) throws IOException;
}
