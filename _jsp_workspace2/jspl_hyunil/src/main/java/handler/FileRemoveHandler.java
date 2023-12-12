package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileRemoveHandler {

	private static final Logger log = LoggerFactory.getLogger(FileRemoveHandler.class);
	
	
	//파일 이름과 경로를 받아 파일을 삭제하는 메서드
	//리턴타입 int => 잘 삭제되었다면 1 , 아니면 0
	public int deleteFile(String imageFileName , String savePath) {
		
		boolean isDel = false ; //삭제가 잘 되었는지 체크하는 변수
		log.info(">>>>> deleteFile method 접근완료~~~" + imageFileName);
		
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir + File.separator + imageFileName);
		File removeThumbFile = new File(fileDir + File.separator + "th_" +imageFileName);
		
		//파일이 존재해야 삭제
		//exists : 값이 있는지 없는지 확인하는 명령어
		if(removeFile.exists() || removeThumbFile.exists()) {
			isDel = removeFile.delete();
			log.info(">>>>> fileRemove : " + (isDel ? "OK" : "Fail"));
			if(isDel) {
				isDel = removeThumbFile.delete();
				log.info(">>>>>>>> fileThumbRemone : " + (isDel ? "OK" : "Faill"));
			}
		}
		
		log.info(">>>> remove OK");
		
		return isDel ? 1:0 ;
	}
	
}