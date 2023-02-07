import unittest
from python.LinkedList import LinkedList


class test_linked_list(unittest.TestCase):

    def test_insert_search(self):
        list = LinkedList()
        list.insert(1)
        list.insert(2)
        self.assertTrue(list.search(1))
        self.assertTrue(list.search(2))
        self.assertFalse(list.search(3))

    def test_insert_search_delete(self):
        list = LinkedList()
        list.insert(1)
        list.insert(2)
        list.insert(3)
        self.assertTrue(list.search(1))
        self.assertTrue(list.search(2))
        self.assertTrue(list.search(3))
        list.remove(1)
        self.assertFalse(list.search(1))
        self.assertTrue(list.search(2))
        self.assertTrue(list.search(3))


if __name__ == '__main__':
    unittest.main()
