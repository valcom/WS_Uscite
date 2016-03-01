/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author valer
 *
 */
public abstract class PageWrapper<T> extends ListContainer<T> {
	
	private Page<T> page;

	public PageWrapper() {
		super();
	}


	public PageWrapper(Page<T> content) {
		super(content.getContent());
		page = content;
	}

	

	public void forEach(Consumer<? super T> arg0) {
		page.forEach(arg0);
	}


	public int getNumber() {
		return page.getNumber();
	}

	public int getNumberOfElements() {
		return page.getNumberOfElements();
	}

	public int getSize() {
		return page.getSize();
	}

	public Sort getSort() {
		return page.getSort();
	}

	public long getTotalElements() {
		return page.getTotalElements();
	}

	public int getTotalPages() {
		return page.getTotalPages();
	}

	public boolean hasContent() {
		return page.hasContent();
	}

	public boolean hasNext() {
		return page.hasNext();
	}

	public boolean hasPrevious() {
		return page.hasPrevious();
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public Iterator<T> iterator() {
		return page.iterator();
	}

	public <S> Page<S> map(Converter<? super T, ? extends S> arg0) {
		return page.map(arg0);
	}

	public Pageable nextPageable() {
		return page.nextPageable();
	}

	public Pageable previousPageable() {
		return page.previousPageable();
	}

	public Spliterator<T> spliterator() {
		return page.spliterator();
	}
	
	
	

}
