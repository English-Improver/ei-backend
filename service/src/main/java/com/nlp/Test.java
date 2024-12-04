package com.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.ling.LabelFactory;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        // 设置NLP的属性，选择所需的annotators
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // 创建一个文本处理的注释（Annotation）
        Annotation annotation = new Annotation("Stumbled upon a yet another AI-generated blog post. As much as I appreciate and admire AI, I think we are moving blazing fast towards the place where genuine content created by people who know what they are talking about will be invaluable");

        // 使用Pipeline处理文本
        pipeline.annotate(annotation);

        // 从这里开始，您可以提取出需要的信息，例如依存树、命名实体、情感等

        // 例如，提取句子和词性标注
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            // 提取句子的文本
            String sentenceText = sentence.get(CoreAnnotations.TextAnnotation.class);
            System.out.println(sentenceText);

            // 提取句子中每个词的词性
//            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
//                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
//                System.out.println(word + " (" + pos + ")");
//            }

            // 提取句子的句法树
            Tree constituencyParse = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            constituencyParse.pennPrint();

            // 提取句子的依存图
            SemanticGraph dependencyGraph = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
            // 查找主语
            IndexedWord subject = null;
            for (SemanticGraphEdge edge : dependencyGraph.edgeIterable()) {
                if (edge.getRelation().toString().equals("nsubj") || edge.getRelation().toString().equals("nsubjpass")) {
                    subject = edge.getGovernor(); // 谓语动词
                    IndexedWord subjWord = edge.getDependent(); // 主语单词
                    System.out.println("主语: " + subjWord.word());
                    break;
                }
            }
            // 查找谓语
            IndexedWord predicate = null;
            for (SemanticGraphEdge edge : dependencyGraph.edgeIterable()) {
                if (edge.getRelation().toString().equals("root")) {
                    predicate = edge.getDependent(); // 谓语动词
                    System.out.println("谓语: " + predicate.word());
                    break;
                }
            }
            // 查找宾语
            IndexedWord object = null;
            for (SemanticGraphEdge edge : dependencyGraph.edgeIterable()) {
                if (edge.getRelation().toString().equals("dobj")) {
                    object = edge.getDependent(); // 宾语单词
                    System.out.println("宾语: " + object.word());
                    break;
                }
            }
            // 查找从句
            for (SemanticGraphEdge edge : dependencyGraph.edgeIterable()) {
                if (edge.getRelation().toString().equals("ccomp")) {
                    IndexedWord ccomp = edge.getDependent(); // 从句单词
                    System.out.println("从句: " + ccomp.word());
                    break;
                }
            }

        }
    }


}
