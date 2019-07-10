package com.google.firebase.appindexing.builders;

import android.support.annotation.NonNull;

public final class PersonBuilder extends IndexableBuilder<PersonBuilder>
{
  PersonBuilder()
  {
    super("Person");
  }

  public PersonBuilder setEmail(@NonNull String paramString)
  {
    return (PersonBuilder)put("email", new String[] { paramString });
  }

  public PersonBuilder setIsSelf(@NonNull boolean paramBoolean)
  {
    return (PersonBuilder)put("isSelf", new boolean[] { paramBoolean });
  }

  public PersonBuilder setTelephone(@NonNull String paramString)
  {
    return (PersonBuilder)put("telephone", new String[] { paramString });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.builders.PersonBuilder
 * JD-Core Version:    0.6.0
 */