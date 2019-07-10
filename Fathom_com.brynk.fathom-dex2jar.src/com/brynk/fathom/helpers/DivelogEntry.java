package com.brynk.fathom.helpers;

public class DivelogEntry
{
  private boolean isConverted;
  private String name;
  private String startTime;
  private String stopTime;
  private String when;
  private String where;

  public DivelogEntry(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.name = paramString1;
    this.when = paramString2;
    this.startTime = paramString3;
    this.stopTime = paramString4;
    this.where = paramString5;
    try
    {
      this.isConverted = Boolean.parseBoolean(paramString6);
      return;
    }
    catch (java.lang.Exception paramString1)
    {
      this.isConverted = false;
    }
  }

  public String getName()
  {
    return this.name;
  }

  public String getStartTime()
  {
    return this.startTime;
  }

  public String getStopTime()
  {
    return this.stopTime;
  }

  public String getWhen()
  {
    return this.when;
  }

  public String getWhere()
  {
    return this.where;
  }

  public boolean isConverted()
  {
    return this.isConverted;
  }

  public void setConverted(boolean paramBoolean)
  {
    this.isConverted = paramBoolean;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
  }

  public void setStopTime(String paramString)
  {
    this.stopTime = paramString;
  }

  public void setWhen(String paramString)
  {
    this.when = paramString;
  }

  public void setWhere(String paramString)
  {
    this.where = paramString;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.helpers.DivelogEntry
 * JD-Core Version:    0.6.0
 */