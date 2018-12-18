package org.alva.ConcurrentBeauty.Chapter02;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ThreadNotSafe {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void inc() {
        ++value;
    }
}


/*

 public void inc();
    Code:
       0: aload_0
       1: aload_0
       2: getfield      #2                  // Field value:Ljava/lang/Long;
       5: invokevirtual #3                  // Method java/lang/Long.longValue:()J
       8: lconst_1
       9: ladd
      10: invokestatic  #4                  // Method java/lang/Long.valueOf:(J)Ljava/lang/Long;
      13: putfield      #2                  // Field value:Ljava/lang/Long;
      16: return
}


public void inc();
    Code:
       0: aload_0
       1: aload_0
       2: getfield      #2                  // Field value:Ljava/lang/Long;
       5: invokevirtual #3                  // Method java/lang/Long.longValue:()J
       8: lconst_1
       9: ladd
      10: invokestatic  #4                  // Method java/lang/Long.valueOf:(J)Ljava/lang/Long;
      13: putfield      #2                  // Field value:Ljava/lang/Long;
      16: return
}

 */