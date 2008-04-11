/*
 * Copyright (C) 2007-2008 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */
package org.geometerplus.zlibrary.core.optionEntries;

import java.util.ArrayList;

import org.geometerplus.zlibrary.core.dialogs.ZLComboOptionEntry;
import org.geometerplus.zlibrary.core.options.ZLStringOption;
import org.geometerplus.zlibrary.core.view.ZLPaintContext;

public class ZLFontFamilyOptionEntry extends ZLComboOptionEntry {
	private ZLStringOption myOption;
	private final ZLPaintContext myContext;
	
	public ZLFontFamilyOptionEntry(ZLStringOption option, final ZLPaintContext context) {
		myOption = option;
		myContext = context;
		String value = option.getValue();
		if (value != null && !value.equals("")) {
			option.setValue(myContext.realFontFamilyName(value));
		}	
	}

	public ArrayList getValues() {
		return (ArrayList) myContext.fontFamilies();
	}

	public String initialValue() {
		return myOption.getValue();
	}

	public void onAccept(String value) {
		myOption.setValue(value);
	}

}