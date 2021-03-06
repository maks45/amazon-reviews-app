package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.exception.DataProcessingException;
import com.maks.durov.amazonreviewapp.service.FileService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class FileServiceImpl implements FileService {

    @Override
    public List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(Objects.requireNonNull(getClass()
                    .getClassLoader().getResource(path)).toURI()));
        } catch (URISyntaxException e) {
            throw new DataProcessingException("wrong uri", e);
        } catch (IOException e) {
            throw new DataProcessingException("can't read file " + path, e);
        }
    }
}
