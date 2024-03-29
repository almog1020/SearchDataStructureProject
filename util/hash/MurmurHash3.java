package util.hash;

import java.nio.ByteBuffer;

/**
 *  The MurmurHash3 algorithm was created by Austin Appleby and placed in the public domain.
 *  This java port was authored by Yonik Seeley and also placed into the public domain.
 *  The author hereby disclaims copyright to this source code.
 *  <p>
 *  This produces exactly the same hash values as the final C++
 *  version of MurmurHash3 and is thus suitable for producing the same hash values across
 *  platforms.
 *  <p>
 *  The 32 bit x86 version of this hash should be the fastest variant for relatively short keys like ids.
 *  murmurhash3_x64_128 is a good choice for longer strings or if you need more than 32 bits of hash.
 *  <p>
 *  Note - The x86 and x64 versions do _not_ produce the same results, as the
 *  algorithms are optimized for their respective platforms.
 *  <p>
 *  See http://github.com/yonik/java_util for future updates to this file.
 */
public final class MurmurHash3 {
  
public static int hash32(long data,int seed)
{
  int offset = 0;
 int hash = MurmurHash3.murmurhash3_x86_32(ByteBuffer.allocate(8).putLong(data).array(), offset, 8, seed);
 return hash;
}
public static int murmurhash3_x86_32(byte[] data, int offset, int len, int seed) {

  final int c1 = 0xcc9e2d51;
  final int c2 = 0x1b873593;

  int h1 = seed;
  int roundedEnd = offset + (len & 0xfffffffc);  // round down to 4 byte block

  for (int i=offset; i<roundedEnd; i+=4) {
    // little endian load order
    int k1 = (data[i] & 0xff) | ((data[i+1] & 0xff) << 8) | ((data[i+2] & 0xff) << 16) | (data[i+3] << 24);
    k1 *= c1;
    k1 = (k1 << 15) | (k1 >>> 17);  // ROTL32(k1,15);
    k1 *= c2;

    h1 ^= k1;
    h1 = (h1 << 13) | (h1 >>> 19);  // ROTL32(h1,13);
    h1 = h1*5+0xe6546b64;
  }

  // tail
  int k1 = 0;

  switch(len & 0x03) {
    case 3:
      k1 = (data[roundedEnd + 2] & 0xff) << 16;
      // fallthrough
    case 2:
      k1 |= (data[roundedEnd + 1] & 0xff) << 8;
      // fallthrough
    case 1:
      k1 |= (data[roundedEnd] & 0xff);
      k1 *= c1;
      k1 = (k1 << 15) | (k1 >>> 17);  
      k1 *= c2;
      h1 ^= k1;
  }

  // finalization
  h1 ^= len;

  h1 ^= h1 >>> 16;
  h1 *= 0x85ebca6b;
  h1 ^= h1 >>> 13;
  h1 *= 0xc2b2ae35;
  h1 ^= h1 >>> 16;

  return h1;
}
}