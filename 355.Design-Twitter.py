# https://leetcode.com/problems/design-twitter/
#
# algorithms
# Medium (27.98%)
# Total Accepted:    37,655
# Total Submissions: 134,594


from collections import defaultdict
from bisect import insort


class Twitter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.follow_map = defaultdict(set)  # 关注列表
        self.followed_map = defaultdict(set)  # 被关注列表
        self.tweet_map = defaultdict(list)  # 用户关注的列表
        self.post_map = defaultdict(list)  # 发布列表
        self.tweet_stamp = 0

    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: None
        """
        self.post_map[userId].append((self.tweet_stamp, tweetId))

        for id in self.followed_map[userId]:
            insort(self.tweet_map[id], (self.tweet_stamp, tweetId))

        insort(self.tweet_map[userId], (self.tweet_stamp, tweetId))

        self.tweet_stamp += 1

    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        length = len(self.tweet_map[userId])
        if length <= 10:
            arr = self.tweet_map[userId]
        else:
            arr = self.tweet_map[userId][length - 10:]

        return [item[-1] for item in reversed(arr)]

    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: None
        """
        if followerId == followeeId:
            return

        if followeeId in self.follow_map[followerId]:
            return

        self.follow_map[followerId].add(followeeId)
        self.followed_map[followeeId].add(followerId)

        for stamp, tweetId in self.post_map[followeeId]:
            insort(self.tweet_map[followerId], (stamp, tweetId))

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: None
        """
        if followerId == followeeId:
            return

        if followeeId not in self.follow_map[followerId]:
            return

        self.follow_map[followerId].remove(followeeId)
        self.followed_map[followeeId].remove(followerId)

        tweet_map = set()
        for stamp, _ in self.post_map[followeeId]:
            tweet_map.add(stamp)

        tmp = []
        for stamp, tweetId in self.tweet_map[followerId]:
            if stamp not in tweet_map:
                tmp.append((stamp, tweetId))

        self.tweet_map[followerId] = tmp

# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
