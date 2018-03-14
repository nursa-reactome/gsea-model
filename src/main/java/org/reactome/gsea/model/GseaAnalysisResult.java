package org.reactome.gsea.model;

public class GseaAnalysisResult {

    private static final double[] UNKNOWN_REG_TYPE_BOUNDS = {-0.001, +0.001};

    public static class Pathway {
        private String name;
        private String stId;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getStId() {
            return stId;
        }
        public void setStId(String stId) {
            this.stId = stId;
        }
    }

    public enum RegulationType {
        UP("Up"),
        UNKNOWN("Unknown"),
        DOWN("Down");
        
        private final String repr;
        
        private RegulationType(final String repr) {
            this.repr = repr;
        }
        
        @Override
        public String toString() {
            return this.repr;
        }
    };

    private Pathway pathway;
    private int hitCount;
    private float score;
    private float normalizedScore;
    private float pvalue;
    private float fdr;
 
    public Pathway getPathway() {
        return pathway;
    }
    
    public void setPathway(Pathway pathway) {
        this.pathway = pathway;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }
    public float getNormalizedScore() {
        return normalizedScore;
    }
    public void setNormalizedScore(float normalizedScore) {
        this.normalizedScore = normalizedScore;
    }
    public float getPvalue() {
        return pvalue;
    }
    public void setPvalue(float pvalue) {
        this.pvalue = pvalue;
    }
    public float getFdr() {
        return fdr;
    }
    public void setFdr(float fdr) {
        this.fdr = fdr;
    }
   
    public RegulationType getRegulationType() {
        float nes = getNormalizedScore();
        if (nes < UNKNOWN_REG_TYPE_BOUNDS[0]) {
            return RegulationType.DOWN;
        } else if (nes < UNKNOWN_REG_TYPE_BOUNDS[1]) {
            return RegulationType.UNKNOWN;
        } else {
            return RegulationType.UP;
        }
    }
}
