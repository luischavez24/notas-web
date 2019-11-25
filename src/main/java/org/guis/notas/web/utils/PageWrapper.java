package org.guis.notas.web.utils;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageWrapper<T> {

    private long recordsTotal;

    private long recordsFiltered;

    private List<T> data;

    private int draw;

    private int display;
    
    public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public PageWrapper(long recordsTotal, long recordsFiltered, List<T> data) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public static <T> PageWrapper<T> of(Page<T> page) {
        return new PageWrapper<T>(page.getTotalElements(), page.getNumberOfElements(), page.getContent());
    }
}
