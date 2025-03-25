package store.Images.services;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FirebaseStorageService {

    public String uploadFile(MultipartFile file) throws IOException {
        Bucket bucket = StorageClient.getInstance().bucket();
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Blob blob = bucket.create(filename, file.getBytes(), file.getContentType());

        return blob.getMediaLink(); // Retorna a URL do arquivo armazenado
    }
}