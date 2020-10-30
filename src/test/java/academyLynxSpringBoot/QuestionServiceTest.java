package academyLynxSpringBoot;

import static org.junit.Assert.*;

import org.junit.Test;

import it.jac.javadb.entity.Question;
import it.jac.javadb.service.QuestionService;

public class QuestionServiceTest {

	@Test
	public void createQuestionTest() {
		Question question = new Question();
		question.setId(1);
		
		QuestionService service = new QuestionService();
		
		service.createQuestion(question);
		
		assertEquals("Nessun elemento trovato.", service.createQuestion(question).getError());
	}

}
