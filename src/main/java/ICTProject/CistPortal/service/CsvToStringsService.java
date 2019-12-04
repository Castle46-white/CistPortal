package ICTProject.CistPortal.service;

import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvToStringsService implements ICsvToStringsService {
    @Override
    public List<String> convert(FileUpload file, Charset charset) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(),charset));
        var lines = new ArrayList<String>();
        bufferedReader.lines().forEach(lines::add);
        bufferedReader.close();
        return lines;
    }
}
