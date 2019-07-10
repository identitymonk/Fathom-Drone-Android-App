package com.facebook.react.flat;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

final class ElementsList<E>
{
  private Scope mCurrentScope = null;
  private final ArrayDeque<E> mElements = new ArrayDeque();
  private final E[] mEmptyArray;
  private int mScopeIndex = 0;
  private final ArrayList<Scope> mScopesStack = new ArrayList();

  public ElementsList(E[] paramArrayOfE)
  {
    this.mEmptyArray = paramArrayOfE;
    this.mScopesStack.add(this.mCurrentScope);
  }

  private E[] extractElements(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.mEmptyArray;
      return localObject;
    }
    Object[] arrayOfObject = (Object[])(Object[])Array.newInstance(this.mEmptyArray.getClass().getComponentType(), paramInt);
    paramInt -= 1;
    while (true)
    {
      localObject = arrayOfObject;
      if (paramInt < 0)
        break;
      arrayOfObject[paramInt] = this.mElements.pollLast();
      paramInt -= 1;
    }
  }

  private Scope getCurrentScope()
  {
    return this.mCurrentScope;
  }

  private void popScope()
  {
    this.mScopeIndex -= 1;
    this.mCurrentScope = ((Scope)this.mScopesStack.get(this.mScopeIndex));
  }

  private void pushScope()
  {
    this.mScopeIndex += 1;
    if (this.mScopeIndex == this.mScopesStack.size())
    {
      this.mCurrentScope = new Scope(null);
      this.mScopesStack.add(this.mCurrentScope);
      return;
    }
    this.mCurrentScope = ((Scope)this.mScopesStack.get(this.mScopeIndex));
  }

  public void add(E paramE)
  {
    Scope localScope = getCurrentScope();
    if ((localScope.index < localScope.elements.length) && (localScope.elements[localScope.index] == paramE))
      localScope.index += 1;
    while (true)
    {
      this.mElements.add(paramE);
      return;
      localScope.index = 2147483647;
    }
  }

  public void clear()
  {
    if (getCurrentScope() != null)
      throw new RuntimeException("Must call finish() for every start() call being made.");
    this.mElements.clear();
  }

  public E[] finish()
  {
    Scope localScope = getCurrentScope();
    popScope();
    Object localObject2 = null;
    int j = this.mElements.size() - localScope.size;
    Object localObject1;
    if (localScope.index != localScope.elements.length)
    {
      localObject1 = extractElements(j);
      localScope.elements = null;
      return localObject1;
    }
    int i = 0;
    while (true)
    {
      localObject1 = localObject2;
      if (i >= j)
        break;
      this.mElements.pollLast();
      i += 1;
    }
  }

  public void start(Object[] paramArrayOfObject)
  {
    pushScope();
    Scope localScope = getCurrentScope();
    localScope.elements = paramArrayOfObject;
    localScope.index = 0;
    localScope.size = this.mElements.size();
  }

  private static final class Scope
  {
    Object[] elements;
    int index;
    int size;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.ElementsList
 * JD-Core Version:    0.6.0
 */