package org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.ui.commands;

import com.google.common.base.Objects;
import fr.inria.diverse.melange.metamodel.melange.Language;
import java.util.List;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class SetECL extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    this.addOrUpdateECL(event);
    return null;
  }
  
  public Language addOrUpdateECL(final ExecutionEvent event) {
    final String newECLpath = "some/where/file.ecl";
    final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
    boolean _notEquals = (!Objects.equal(editor, null));
    if (_notEquals) {
      ISelectionProvider _selectionProvider = editor.getSelectionProvider();
      ISelection _selection = _selectionProvider.getSelection();
      final ITextSelection selection = ((ITextSelection) _selection);
      IXtextDocument _document = editor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function = (XtextResource it) -> {
        int _offset = selection.getOffset();
        final Language lang = this.getSelectedLanguage(it, _offset);
        if ((lang != null)) {
          IXtextDocument _document_1 = editor.getDocument();
          this.addOrUpdateECL(_document_1, lang, newECLpath);
          return null;
        }
        return null;
      };
      _document.<Object>modify(_function);
    }
    return null;
  }
  
  public Language getSelectedLanguage(final XtextResource resource, final int offset) {
    IResourceServiceProvider _resourceServiceProvider = resource.getResourceServiceProvider();
    final EObjectAtOffsetHelper eObjectAtOffsetHelper = _resourceServiceProvider.<EObjectAtOffsetHelper>get(EObjectAtOffsetHelper.class);
    final EObject selectedElement = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
    boolean _notEquals = (!Objects.equal(selectedElement, null));
    if (_notEquals) {
      EObject currentElem = selectedElement;
      while ((currentElem != null)) {
        {
          if ((currentElem instanceof Language)) {
            return ((Language)currentElem);
          }
          EObject _eContainer = currentElem.eContainer();
          currentElem = _eContainer;
        }
      }
    }
    return null;
  }
  
  public void addOrUpdateECL(final IXtextDocument document, final Language language, final String newEclPath) {
    try {
      EClass _eClass = language.eClass();
      final EStructuralFeature ecl = _eClass.getEStructuralFeature("ecl");
      final List<INode> nodesEcl = NodeModelUtils.findNodesForFeature(language, ecl);
      boolean _isEmpty = nodesEcl.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final INode nodeECL = IterableExtensions.<INode>head(nodesEcl);
        int _offset = nodeECL.getOffset();
        int _length = nodeECL.getLength();
        document.replace(_offset, _length, (("\"" + newEclPath) + "\""));
      } else {
        EClass _eClass_1 = language.eClass();
        final EStructuralFeature operators = _eClass_1.getEStructuralFeature("operators");
        final List<INode> nodesOp = NodeModelUtils.findNodesForFeature(language, operators);
        int lastOffset = (-1);
        for (final INode node : nodesOp) {
          int _endOffset = node.getEndOffset();
          boolean _greaterThan = (_endOffset > lastOffset);
          if (_greaterThan) {
            int _endOffset_1 = node.getEndOffset();
            lastOffset = _endOffset_1;
          }
        }
        if ((lastOffset != (-1))) {
          document.replace(lastOffset, 0, (("\n\n\tecl \"" + newEclPath) + "\""));
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
