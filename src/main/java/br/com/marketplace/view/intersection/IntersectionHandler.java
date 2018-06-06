package br.com.marketplace.view.intersection;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Scope(value = "session")
@Component(value = "intersection")
@ELBeanName(value = "intersection")
@Join(path = "/intersection", to = "/intersection/intersection.jsf")
public class IntersectionHandler {

	private Double firstIntervalOne;
	private Double secondIntervalOne;
	private Double firstIntervalTwo;
	private Double secondIntervalTwo;

	public Double getFirstIntervalOne() {
		return firstIntervalOne;
	}

	public void setFirstIntervalOne(Double firstIntervalOne) {
		this.firstIntervalOne = firstIntervalOne;
	}

	public Double getSecondIntervalOne() {
		return secondIntervalOne;
	}

	public void setSecondIntervalOne(Double secondIntervalOne) {
		this.secondIntervalOne = secondIntervalOne;
	}

	public Double getFirstIntervalTwo() {
		return firstIntervalTwo;
	}

	public void setFirstIntervalTwo(Double firstIntervalTwo) {
		this.firstIntervalTwo = firstIntervalTwo;
	}

	public Double getSecondIntervalTwo() {
		return secondIntervalTwo;
	}

	public void setSecondIntervalTwo(Double secondIntervalTwo) {
		this.secondIntervalTwo = secondIntervalTwo;
	}

	public void validate(){
		boolean hasOverlap = firstIntervalOne > secondIntervalTwo || firstIntervalTwo < secondIntervalOne;
		if(hasOverlap){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tem interceção", ""));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não tem interceção", ""));
		}
	}

}
