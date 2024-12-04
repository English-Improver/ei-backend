package com.nlp;

/**
 * 语法关系枚举类
 * @author yitiansong
 */
@Deprecated
public enum GrammaticalRelations {
    PREDICATE("pred", "predicate", "谓语"),
    AUX_MODIFIER("aux", "auxiliary", "助动词"),
    AUX_PASSIVE_MODIFIER("auxpass", "auxiliary (passive)", "被动助动词"),
    COPULA("cop", "copula", "系动词"),
    CONJUNCT("conj", "conjunct", "并列关系"),
    COORDINATION("cc", "coordination", "协调关系"),
    PUNCTUATION("punct", "punctuation", "标点符号"),
    ARGUMENT("arg", "argument", "论元"),
    SUBJECT("subj", "subject", "主语"),
    NOMIMAL_SUBJECT("nsubj", "nominal subject", "名词性主语"),
    NOMIMAL_PASSIVE_SUBJECT("nsubjpass", "nominal passive subject", "被动句名词性主语"),
    CLAUSAL_SUBJECT("csubj", "clausal subject", "从句主语"),
    CLAUSAL_PASSIVE_SUBJECT("csubjpass", "clausal passive subject", "被动句从句主语"),
    COMPLEMENT("comp", "complement", "补语"),
    OBJECT("obj", "object", "宾语"),
    DIRECT_OBJECT("dobj", "direct object", "直接宾语"),
    INDIRECT_OBJECT("iobj", "indirect object", "间接宾语"),
    PREPOSITIONAL_OBJECT("pobj", "prepositional object", "介词宾语"),
    PREPOSITIONAL_COMPLEMENT("pcomp", "prepositional complement", "介词补语"),
    CLAUSAL_COMPLEMENT("ccomp", "clausal complement", "从句补语"),
    XCLAUSAL_COMPLEMENT("xcomp", "open clausal complement", "开放式从句补语"),
    RELATIVE("rel", "relative", "关系"),
    REFERENT("ref", "referent", "指示"),
    EXPLETIVE("expl", "expletive", "虚词"),
    ADJECTIVAL_COMPLEMENT("acomp", "adjectival complement", "形容词补语"),
    MODIFIER("mod", "modifier", "修饰语"),
    ADV_CLAUSE_MODIFIER("advcl", "adverbial clause modifier", "状语从句修饰语"),
    RELATIVE_CLAUSE_MODIFIER("acl", "relative clause modifier", "关系从句修饰语"),
    MARKER("mark", "marker", "标记"),
    ADJECTIVAL_MODIFIER("amod", "adjectival modifier", "形容词修饰语"),
    NUMERIC_MODIFIER("nummod", "numeric modifier", "数词修饰语"),
    NUMBER_MODIFIER("number", "number modifier", "数字修饰语"),
    QUANTIFIER_MODIFIER("quantmod", "quantifier modifier", "量词修饰语"),
    NOUN_COMPOUND_MODIFIER("nn", "noun compound modifier", "名词复合修饰语"),
    APPOSITIONAL_MODIFIER("appos", "appositional modifier", "同位语修饰语"),
    DISOURSE_ELEMENT("discourse", "discourse element", "话语成分"),
    VERBAL_MODIFIER("vmod", "verbal modifier", "动词修饰语"),
    ADVERBIAL_MODIFIER("advmod", "adverbial modifier", "状语修饰语"),
    NEGATION_MODIFIER("neg", "negation modifier", "否定修饰语"),
    NP_ADVERBIAL_MODIFIER("npadvmod", "noun phrase as adverbial modifier", "名词短语作状语修饰语"),
    TEMPORAL_MODIFIER("tmod", "temporal modifier", "时间修饰语"),
    MULTIWORD_EXPRESSION("mwe", "multiword expression", "多词表达"),
    DETERMINER("det", "determiner", "限定词"),
    PREDETERMINER("predet", "predeterminer", "前限定词"),
    PRECONJUNCT("preconj", "preconjunct", "前连接词"),
    POSSESSION_MODIFIER("poss", "possession modifier", "所有格修饰语"),
    POSSESSIVE_MODIFIER("possessive", "possessive modifier", "所有格修饰语"),
    PREPOSITIONAL_MODIFIER("prep", "prepositional modifier", "介词修饰语"),
    PHRASAL_VERB_PARTICLE("prt", "phrasal verb particle", "动词短语粒子"),
    PARATAXIS("parataxis", "parataxis", "并列句法"),
    GOES_WITH("goeswith", "goes with", "搭配"),
    SEMANTIC_DEPENDENT("dep", "semantic dependent", "语义依赖");



    // 成员变量
    private final String shortName;
    private final String longName;
    private final String chineseName;

    // 构造方法
    GrammaticalRelations(String shortName, String longName, String chineseName) {
        this.shortName = shortName;
        this.longName = longName;
        this.chineseName = chineseName;
    }

    // 获取方法
    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getChineseName() {
        return chineseName;
    }

    // 根据shortName获取枚举实例的方法
    public static GrammaticalRelations getByShortName(String shortName) {
        for (GrammaticalRelations relation : values()) {
            if (relation.getShortName().equals(shortName)) {
                return relation;
            }
        }
        throw new IllegalArgumentException("No constant with short name " + shortName + " found");
    }
}

