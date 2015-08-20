package com.note4j.InsertInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Show Tags
 * 
 * @author changwei
 *
 */

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		if (intervals == null || newInterval == null) {
			return intervals;
		}

		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		ListIterator<Interval> it = intervals.listIterator();
		while (it.hasNext()) {
			Interval tmpInterval = it.next();
			if (newInterval.end < tmpInterval.start) {
				it.previous();
				it.add(newInterval);
				return intervals;
			} else {
				if (tmpInterval.end < newInterval.start) {
					continue;
				} else {
					newInterval.start = Math.min(tmpInterval.start,
							newInterval.start);
					newInterval.end = Math
							.max(tmpInterval.end, newInterval.end);
					it.remove();
				}
			}
		}
		intervals.add(newInterval);
		return intervals;
	}

	public static void main(String[] args) {
		Interval interval = new Interval(1, 2);
		ArrayList<Interval> intervalList = new ArrayList<Interval>();
		intervalList.add(interval);
		interval = new Interval(3, 5);
		intervalList.add(interval);
		interval = new Interval(6, 7);
		intervalList.add(interval);
		interval = new Interval(8, 10);
		intervalList.add(interval);
		interval = new Interval(12, 16);
		intervalList.add(interval);

		Interval tempInterval = new Interval(4, 9);
		new InsertInterval().insert(intervalList, tempInterval);
		for (int i = 0; i != intervalList.size() - 1; i++) {
			Interval inter = intervalList.get(i);
			System.out.print("[" + inter.start + "," + inter.end + "],");
		}
		System.out.print("[" + intervalList.get(intervalList.size() - 1).start
				+ "," + intervalList.get(intervalList.size() - 1).end + "]");
	}
}