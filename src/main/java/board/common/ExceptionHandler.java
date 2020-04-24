  
package board.common;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //예외처리 클래스를 의미
@Slf4j
public class ExceptionHandler {
	
	//해당 메서드에서 처리할 예외를 지정. 테스트를 위해 Exception으로 했지만 실제는 각각의 예외로 처리
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception){
		ModelAndView mv = new ModelAndView("/error/error_default"); //에러시 보여줄 화면
		mv.addObject("exception", exception);
		
		log.error("defaultExceptionHandler", exception); //로그 출력
		
		return mv;
	}
}