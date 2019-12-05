package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.languages;

import java.util.Collection;

import org.eclipse.gemoc.xdsmlframework.api.extensions.Extension;
import org.eclipse.gemoc.xdsmlframework.api.extensions.ExtensionPoint;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;

public abstract class AbstractConcurrentLanguageExtensionPoint<L extends LanguageDefinitionExtension>
		extends ExtensionPoint<L> {

	protected AbstractConcurrentLanguageExtensionPoint(Class<? extends Extension> extensionClazz) {
		super(extensionClazz);
	}

	public Collection<L> getSpecifications() {
		return this.internal_getSpecifications();
	}

	public L findDefinition(String languageName) {
		for (L extension : getSpecifications()) {
			if (extension.getName().equals(languageName)) {
				return extension;
			}
		}
		return null;
	}

}
