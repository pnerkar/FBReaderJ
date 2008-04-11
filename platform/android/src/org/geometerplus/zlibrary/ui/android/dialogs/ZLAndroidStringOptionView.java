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
package org.geometerplus.zlibrary.ui.android.dialogs;

import android.content.Context;
import android.view.*;
import android.widget.*;

import org.geometerplus.zlibrary.core.dialogs.ZLStringOptionEntry;

class ZLAndroidStringOptionView extends ZLAndroidOptionView {
	private TextView myLabel;
	private EditText myEditor;
	protected ZLAndroidStringOptionView(ZLAndroidDialogContent tab, String name, ZLStringOptionEntry option) {
		super(tab, name, option);
	}

	protected void createItem() {
		final Context context = myTab.getView().getContext();
		if (myName != null) {
			myLabel = new TextView(context);
			myLabel.setText(myName);
			myLabel.setPadding(0, 12, 0, 12);
			myLabel.setTextSize(18);
		}
		final ZLStringOptionEntry stringEntry = (ZLStringOptionEntry)myOption;
		myEditor = new EditText(context) {
			protected boolean getDefaultEditable() {
				return stringEntry.isActive();
			}
		};
		myEditor.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		myEditor.setText(stringEntry.initialValue());
	}

	void addAndroidViews() {
		myTab.addAndroidView(myLabel, false);
		myTab.addAndroidView(myEditor, true);
	}

	protected void reset() {
		if (myEditor != null) {
			final ZLStringOptionEntry stringEntry = (ZLStringOptionEntry)myOption;
			myEditor.setText(stringEntry.initialValue());	
		}
	}

	protected void _onAccept() {
		((ZLStringOptionEntry)myOption).onAccept(myEditor.getText().toString());
	}
}