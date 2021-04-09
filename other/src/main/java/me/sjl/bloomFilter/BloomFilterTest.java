package me.sjl.bloomFilter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;

public class BloomFilterTest {

    public static void main(String[] args) {
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 200, 1E-7);

        bloomFilter.put("测试");


        boolean b = bloomFilter.mightContain("测试测试测试测试测试测试测试");
        System.out.println(b);



    }

}
