package kodlamaio.hrms.core.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.ResponsiveBreakpoint;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {

	private Cloudinary cloudinary;
	
	public CloudinaryManager() {
		Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","coder-group" );
        valuesMap.put("api_key", "778744187688522" );
        valuesMap.put("api_secret","oeIxcWkvIxAl7Ey5PQeTCy5mD74" );
        cloudinary = new Cloudinary(valuesMap);
	}

	@Override
	public DataResult<Map<String, String>> upload(String photoLink) {
        try {
            //Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            var result = cloudinary.uploader().upload(photoLink, 
            		  ObjectUtils.asMap(
            		    "responsive_breakpoints", 
            		      new ResponsiveBreakpoint()
            		       .createDerived(true)
            		       .bytesStep(20000)
            		       .minWidth(200)
            		       .maxWidth(1000)));
            
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yüklenemedi");
        }
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
	}
	
	private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
