public class Tamagotchi {
  private String mPetName;
  private int mFoodLevel;
  private int mSleepLevel;
  private int mActivityLevel;

  public Tamagotchi(String name){
    mPetName = name;
    mFoodLevel = 10;
    mSleepLevel = 10;
    mActivityLevel = 10;
  }

  public String getName(){
    return mPetName;
  }

  public int getFoodLevel(){
    return mFoodLevel;
  }

  public int getSleepLevel(){
    return mSleepLevel;
  }

  public int getActivityLevel(){
    return mActivityLevel;
  }

  public int timePasses(){
    mFoodLevel = getFoodLevel() - 1;
    return mFoodLevel;
  }

  public boolean isAlive(){
    if(mFoodLevel > 0){
      return true;
    }
    return false;
  }

  public int setFoodLevel(int foodLevel){
    mFoodLevel = foodLevel;
    return mFoodLevel;
  }
}
