/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.diagnostics;

import com.intellij.psi.PsiElement;
/**
 * @author svtk
 */
public class UnusedElementDiagnosticFactory<T extends PsiElement, A> extends PsiElementOnlyDiagnosticFactory1<T, A> {
    public static <T extends PsiElement, A> UnusedElementDiagnosticFactory<T, A> create(Severity severity, String messageStub) {
        return new UnusedElementDiagnosticFactory<T, A>(severity, messageStub);
    }

    public static <T extends PsiElement, A> UnusedElementDiagnosticFactory<T, A> create(Severity severity, String messageStub, Renderer renderer) {
        return new UnusedElementDiagnosticFactory<T, A>(severity, messageStub, renderer);
    }

    public UnusedElementDiagnosticFactory(Severity severity, String message, Renderer renderer) {
        super(severity, message, renderer);
    }

    protected UnusedElementDiagnosticFactory(Severity severity, String message) {
        super(severity, message);
    }
}
