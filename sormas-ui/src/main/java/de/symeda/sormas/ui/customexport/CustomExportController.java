/*
 * SORMAS® - Surveillance Outbreak Response Management & Analysis System
 * Copyright © 2016-2021 Helmholtz-Zentrum für Infektionsforschung GmbH (HZI)
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package de.symeda.sormas.ui.customexport;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import com.vaadin.server.Page;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import de.symeda.sormas.api.FacadeProvider;
import de.symeda.sormas.api.contact.ContactCriteria;
import de.symeda.sormas.api.i18n.Captions;
import de.symeda.sormas.api.i18n.I18nProperties;
import de.symeda.sormas.api.i18n.Strings;
import de.symeda.sormas.api.importexport.ExportConfigurationDto;
import de.symeda.sormas.api.importexport.ExportPropertyMetaInfo;
import de.symeda.sormas.api.importexport.ExportType;
import de.symeda.sormas.api.importexport.ImportExportUtils;
import de.symeda.sormas.api.person.PersonCriteria;
import de.symeda.sormas.api.task.TaskCriteria;
import de.symeda.sormas.ui.utils.ContactDownloadUtil;
import de.symeda.sormas.ui.utils.PersonDownloadUtil;
import de.symeda.sormas.ui.utils.TaskDownloadUtil;
import de.symeda.sormas.ui.utils.VaadinUiUtil;

public class CustomExportController {

	public void openContactExportWindow(ContactCriteria contactCriteria, Supplier<Collection<String>> selectedRows) {
		Window customExportWindow = VaadinUiUtil.createPopupWindow();
		ExportConfigurationsLayout customExportsLayout = new ExportConfigurationsLayout(
			ExportType.CONTACT,
			ImportExportUtils.getContactExportProperties(
				ContactDownloadUtil::getPropertyCaption,
				FacadeProvider.getConfigFacade().getCountryLocale(),
				FacadeProvider.getFeatureConfigurationFacade().getActiveServerFeatureConfigurations()),
			customExportWindow::close);
		customExportsLayout.setExportCallback(
			exportConfig -> Page.getCurrent()
				.open(ContactDownloadUtil.createContactExportResource(contactCriteria, selectedRows, exportConfig), null, true));
		customExportWindow.setWidth(1024, Sizeable.Unit.PIXELS);
		customExportWindow.setCaption(I18nProperties.getCaption(Captions.exportCustom));
		customExportWindow.setContent(customExportsLayout);
		UI.getCurrent().addWindow(customExportWindow);
	}

	public void openTaskExportWindow(TaskCriteria taskCriteria, Supplier<Collection<String>> selectedRows) {
		Window customExportWindow = VaadinUiUtil.createPopupWindow();
		ExportConfigurationsLayout customExportsLayout = new ExportConfigurationsLayout(
			ExportType.TASK,
			ImportExportUtils.getTaskExportProperties(
				TaskDownloadUtil::getPropertyCaption,
				FacadeProvider.getConfigFacade().getCountryLocale(),
				FacadeProvider.getFeatureConfigurationFacade().getActiveServerFeatureConfigurations()),
			customExportWindow::close);
		customExportsLayout.setExportCallback(
			exportConfig -> Page.getCurrent().open(TaskDownloadUtil.createTaskExportResource(taskCriteria, selectedRows, exportConfig), null, true));
		customExportWindow.setWidth(1024, Sizeable.Unit.PIXELS);
		customExportWindow.setCaption(I18nProperties.getCaption(Captions.exportCustom));
		customExportWindow.setContent(customExportsLayout);
		UI.getCurrent().addWindow(customExportWindow);
	}

	public void openPersonExportWindow(PersonCriteria personCriteria) {
		Window customExportWindow = VaadinUiUtil.createPopupWindow();
		ExportConfigurationsLayout customExportsLayout = new ExportConfigurationsLayout(
			ExportType.PERSON,
			ImportExportUtils.getPersonExportProperties(
				PersonDownloadUtil::getPropertyCaption,
				FacadeProvider.getConfigFacade().getCountryLocale(),
				FacadeProvider.getFeatureConfigurationFacade().getActiveServerFeatureConfigurations()),
			customExportWindow::close);
		customExportsLayout.setExportCallback(
			exportConfig -> Page.getCurrent().open(PersonDownloadUtil.createPersonExportResource(personCriteria, exportConfig), null, true));
		customExportWindow.setWidth(1024, Sizeable.Unit.PIXELS);
		customExportWindow.setCaption(I18nProperties.getCaption(Captions.exportCustom));
		customExportWindow.setContent(customExportsLayout);
		UI.getCurrent().addWindow(customExportWindow);
	}

	public void openEditExportConfigurationWindow(
		ExportConfigurationsGrid grid,
		ExportConfigurationDto config,
		List<ExportPropertyMetaInfo> availableProperties,
		String caption) {

		Window exportWindow = VaadinUiUtil.createPopupWindow();
		ExportConfigurationEditLayout editLayout = new ExportConfigurationEditLayout(config, availableProperties, (exportConfiguration) -> {
			FacadeProvider.getExportFacade().saveExportConfiguration(exportConfiguration);
			exportWindow.close();
			new Notification(null, I18nProperties.getString(Strings.messageExportConfigurationSaved), Notification.Type.WARNING_MESSAGE, false)
				.show(Page.getCurrent());
			grid.reload(false);
		}, () -> {
			exportWindow.close();
			grid.reload(false);
		});
		exportWindow.setWidth(1024, Sizeable.Unit.PIXELS);
		exportWindow.setCaption(caption);
		exportWindow.setContent(editLayout);
		UI.getCurrent().addWindow(exportWindow);
	}
}
