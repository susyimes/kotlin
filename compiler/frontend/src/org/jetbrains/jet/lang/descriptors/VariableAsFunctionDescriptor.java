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

package org.jetbrains.jet.lang.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.lang.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.jet.lang.types.JetType;

import java.util.Collections;

/**
 * @author abreslav
 */
public class VariableAsFunctionDescriptor extends FunctionDescriptorImpl {
    public static VariableAsFunctionDescriptor create(@NotNull VariableDescriptor variableDescriptor) {
        JetType outType = variableDescriptor.getOutType();
        assert outType != null;
        VariableAsFunctionDescriptor result = new VariableAsFunctionDescriptor(variableDescriptor);
        FunctionDescriptorUtil.initializeFromFunctionType(result, outType, variableDescriptor.getExpectedThisObject());
        return result;
    }

    private final VariableDescriptor variableDescriptor;

    private VariableAsFunctionDescriptor(VariableDescriptor variableDescriptor) {
        super(variableDescriptor.getContainingDeclaration(), Collections.<AnnotationDescriptor>emptyList(), variableDescriptor.getName(), Kind.DECLARATION);
        this.variableDescriptor = variableDescriptor;
    }

    public VariableDescriptor getVariableDescriptor() {
        return variableDescriptor;
    }

    @NotNull
    @Override
    public VariableAsFunctionDescriptor copy(DeclarationDescriptor newOwner, boolean makeNonAbstract, Kind kind, boolean copyOverrides) {
        throw new UnsupportedOperationException("Should not be copied for overriding");
    }

    @Override
    protected FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor newOwner, boolean preserveOriginal, Kind kind) {
        throw new IllegalStateException();
    }
}
