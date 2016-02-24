/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author vcompagnone
 *
 */
@Component
public class Assembler{

	@Autowired
	protected Mapper mapper;
	
}
