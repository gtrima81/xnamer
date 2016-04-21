# (x)namer
#### a simple random name generator with big dreams 

__Currently provided in Java and Python implementations__

## Summary

(x)namer is a random name generator for fictional place names (v 0.1). 
In the future it will generate fictional names for people, places and/or 
things by combining word bits contained in its data files according to 
various rules.

The current (first working anything) implementation is pretty basic - (x)namer is 
actually a feature I needed for a seperate project but as I was sketching that out 
it seemed like the name generation feature would have greater utility as a stand alone


### Usage

```
java -jar xnamer-0.1.jar
```
 
or

```
python SimplePlaceNamer.py
```

one random name will be printed to the terminal. 

Developers can import either the jar or the python class 
(TODO: make python implementation a proper class) and use `SimplePlaceNamer.get_name()`
to get a name, for example:

```java
import com.hanleybrand.xnamer.SimplePlaceNamer
import java.io.IOException;

public class Main {
    public static void main() throws IOException{
        SimplePlaceNamer sp = new SimplePlaceNamer();
        String this_name = sp.get_name();
        // etc etc
    }
}
```

#### Example Output 

The initial data file is constructed from [Norman toponymic appellatives](https://en.wikipedia.org/wiki/Norman_toponymy#Normanic_place_names "Norman toponymy"), both current and historical all kind of mashed up for now. If someone needs to use this before I add more data files, simply edit the file `resources/main/data/place/ald-normanish.json` without changing the name. In the future you will be able to specify different data files.

> Alorvella, Tombevic, Tombebœuf, Climer, Écwella, Valtoft, Torpbóð, Torpklif, Thuitcourt, Étennemer, Dēopdal, Alortofte, Tombequier, Auppecher, Alrecheryard, Bokibreque, Yclonde, Couralrech, Djuprchurch, Étennethorp, Bucutourps, Dalrbu, Écorchehurs, Plūme lif, Crāweacum, Escalisgate, Londedalle, Sausbeuf, Bodasacum, Eski bóð, Tiefdalle, Rouvy, Crāwebœuf, Orchergate


## Building from source

1. clone repo
2. ./gradlew build
3. java -jar build/libs/xnamer-0.1.jar 

if you just want to play with the names, the python route is easier if you have python installed (the python class has no dependencies to install, it should 'just work' as long as you have python 2.7 installed)


## Future plans

* __FEATURE:__ config file?  Why not, eveybody's doing it!
* __FEATURE:__ specify generation from a specific data file or maybe even from sets of data files
* __FEATURE:__ specify multiple generation rules per data file
  * __FEATURE:__ ability to specify specific rules per generation
* __FEATURE:__ make parsing of data files more flexible so more than two wordbit types can be made available
* __FEATURE:__ ability to specify multiple generation rules per data file


### Future Usage

The example  below illustrates my current future plans for the library - data files will allow for more targeted name generation to make it easier to generate multiple names that all follow a similar logic, so that usage will become something akin to

```java

// make a placeNamer using either language data file 
PlaceNamer pn = new PlaceNamer(){{
    use_languages = ["ald-normanish, germanic"];
}};

// make a placeNamer using any data file that lists 'village' in it's SETS list.
PlaceNamer vpn = new PlaceNamer(){{
    use_sets = ["village"];
}};

// generate a village name using a rule selected randomly
// this might generate "Eskifleur" or "Sauxbroc"
vpn.get_name();

// generate an ald-normanish or germanic name using a specified rule
// this might generate "Eskifleur" or "Sauxbroc"
pn.get_name_by_rule("WATER");

// this might generate "Alix-les-gate" or "Saux-en-bec"
pn.get_name_by_rule("B");

```

using a .json file similar to: 

```javascript

{
  "META" : {
    "LANGUAGE" : "ald-normanish",
    "SETS" : ["village", "town", "European", "fantasy", "modern"]
  },
  "RULES" : {
    "A" : ["MOD_PREFIX","MOD_SUFFIX"],
    "B" : ["ARC_PREFIX", "-", "PREPOSITION", "-", "MOD_SUFFIX"],
    "WATER" : ["ARC_PREFIX","WATER_SUFFIX"],
    "MOUNTAIN" : ["PREFIX","MNT_SUFFIX"]
  },
  "MOD_PREFIX": [
    "crique",
    "escalis",
    "thuit"
  ],
  "MOD_SUFFIX": [
    "bec",
    "court",
    "gate",
    "ville"
  ],
  "ARC_PREFIX": [
    "alix",
    "eski",
    "saux"
  ],
  "ARC_SUFFIX": [
    "boki",
    "garðr",
    "holmr",
    "kjarr"
  ],
  "WATER_SUFFIX": [
    "broc",
    "fleur",
    "mer",
    "vy"
  ],
  "MNT_SUFFIX": [
    "brecque",
    "clives",
    "kliff",
    "steinn"
  ],
  "PREPOSITION": [
    "les",
    "san",
    "l'",
    "en"
  ]
}

```

For efficiency, it may make more sense to auto-create dynamic Namer objects on initialization and then invoke them differently, but we'll burn that bridge when we come to it. 