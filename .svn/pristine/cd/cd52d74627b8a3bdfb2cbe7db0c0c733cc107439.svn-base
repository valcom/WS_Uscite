/**
 * 
 */
package it.ccse.uscite.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;

/**
 * @author vcompagnone
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"file:src/main/webapp/WEB-INF/application-context.xml","classpath:/spring/datasource.xml","classpath:/spring/mail.xml"} )
@WebAppConfiguration
@Transactional
public class PraticaErogazioneServiceTest {
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@Test
	public void testLoadByID(){
		Integer id = 4733;
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		Assert.notNull(pratica);
	}
	@Test
	public void testDelete(){
		Integer id = 11037;
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		praticaErogazioneService.delete(pratica);
		pratica = praticaErogazioneService.getById(id);
		Assert.isNull(pratica);
	
	}
	
	@Test
	public void testInsert(){
		Integer id = 11037;
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		praticaErogazioneService.delete(pratica);
		pratica.setLavorazioneContabile(StatoPratica.UNDEFINED);
		praticaErogazioneService.createPraticaErogazione(pratica);
		Assert.notNull(pratica);
	}
	
	@Test
	public void testUpdate(){
		Integer id = 4733;
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		Integer annoDaInserire = 2013;
		pratica.setAnno(annoDaInserire);
		praticaErogazioneService.savePraticaErogazione(pratica);
		pratica = praticaErogazioneService.getById(id);
		boolean test = pratica.getAnno().equals(annoDaInserire);
		Assert.isTrue(test);
	}

	@Test
	public void testGetByCodicePratica(){
		String codicePratica = "2013B0215212V11DICXX0GASDSTD01";
		PraticaErogazione pratica = praticaErogazioneService.getByCodicePratica(codicePratica);
		Assert.notNull(pratica);
		Assert.isTrue(pratica.getCodicePratica().equals(codicePratica));
	}
}
