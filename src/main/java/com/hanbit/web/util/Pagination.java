package com.hanbit.web.util;

import com.hanbit.web.constants.Values;

public class Pagination {
	public static int[] getRows(int totCount, int pgNum, int pgSize) {

		int startRow = 0, endRow = 0;
		int[] rows = new int[2];

		if (pgNum <= totCount / pgSize + 1) {
			if (pgNum == 1) {
				startRow = 1;
				endRow = pgSize;
			} else {
				startRow = (pgNum - 1) * pgSize + 1;
				endRow = pgNum * pgSize;
			}
		}
		rows[0] = startRow;
		rows[1] = endRow;
		return rows;
	}
	public static int[] getPages(int totCount, int pgNum){
		int[] pages = new int[3];
		int startPg = 0, lastPg = 0, totPg = 0;
		int pgSize = Values.PG_SIZE;
		totPg = (totCount % pgSize == 0)?totCount/pgSize:totCount/pgSize+1;
		lastPg = (startPg + pgSize-1 <= totPg)?startPg+pgSize -1:totPg;
		startPg = pgNum - ((pgNum-1)%pgSize);
		pages[0] = startPg;
		pages[1] = lastPg;
		pages[2] = totPg;
		return pages;
	}
}