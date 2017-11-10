package org.reactome.gsea.model;

public class AnalysisResult {

    public enum RegulationType {
        UP("Up"),
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

    private String pathway;
    private float score;
    private float normalizedScore;
    private float pvalue;
    private float fdr;
 
    public String getPathway() {
        return pathway;
    }
    
    public void setPathway(String pathway) {
        this.pathway = pathway;
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
        return this.getNormalizedScore() > 0 ? RegulationType.UP : RegulationType.DOWN;
    }
}
