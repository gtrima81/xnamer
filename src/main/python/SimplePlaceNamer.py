import json
from random import choice


class SimplePlaceNamer:
    def __init__(self):
        self.data_path = '../resources/data/place/ald-normanish.json'
        self.parts = self.open_the_json(self.data_path)

    def get_name(self):
        return choice(self.parts['PREFIX_A']) + choice(self.parts['SUFFIX_A'])

    def test_out(self, how_many=10):
        for out in xrange(how_many):
            print self.get_name()

        for part in self.parts:
            print '%i choices in part %s' % (len(self.parts[part]), part)

    @staticmethod
    def save_the_json(json_str, file_path):
        with open(file_path, 'w') as json_file:
            json_file.write(json_str)

    @staticmethod
    def open_the_json(filepath):
        with open(filepath) as f:
            text = f.read()
        return json.loads(text)


if __name__ == "__main__":
    x = SimplePlaceNamer()
    x.test_out()

    x = SimplePlaceNamer()
